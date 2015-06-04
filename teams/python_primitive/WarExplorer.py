# fonction action pour un agent Explorer de Warbot 
# code minimal pour l'Explorer que cherche la nourriture
# et la rapporte à la Base quand son sac est plein

def actionExplorer():

    for percept in getPerceptsFood() : # on regarde toutes les Food que l'on void

        setDebugString("View Food");

        if(pickableFood(percept) and isNotBagFull()): # si on est à porter de prendre la Food et que 
            
            setDebugString("Take food");               # notre sac n'est pas plein
            
            followTarget(percept); # alors on se met dans la même direction que notre cible 
            
            return take(); # et on fait l'action de prendre

        elif (isNotBagFull()): # sinon si notre sac n'est pas plein et que l'on est trop loin de la cible
            
            followTarget(percept); # on se dirige vers la cible

    if(isBagFull()): # si notre sac est plein de Food
        
        setDebugString("Bag full return base");

        __percept = getPerceptsAlliesWarBase(); # on regarde si on vois nos Bases

        if(haveNoTargets(__percept)): # si on ne voie aucune Base
            
            for message in getMessages(): # on regarde tout nos messages que l'on reçoie
                
                if(isMessageOfWarBase(message)): # si notre message vien d'une Base
                    
                    followTarget(message); # on se dirige vers l'agent qui nous envoie ce message

            sendMessageToBases("whereAreYou", ""); # on envoie un message au bases pour s'avoir où elles sont

        else : # sinon si on voie au moins une Base
            __base = __percept[0]; # on prend la première base que l'on voit

            if(isPossibleToGiveFood(__base)) : # si on est à porter pour donner de la nourriture
                
                giveToTarget(__base); # on doit se préparer à lui donner
                
                return give(); # et on fait l'action de donner

            else: # sinon si on est trop loin de la Base pour lui donner la Food
                
                followTarget(__base); # on la suit
                
                return move(); # et on réalise l'action de se déplacer
    else :
        setDebugString("Chercher food"); # sinon on continue de cherche de le Food

    if (isBlocked()) : # si jamais notre agent est bloqué

        RandomHeading() # on vas dans une direction au hasard

    return move(); # dans tout les cas on réalise l'action de se déplacer
