Homework:   -Am reusit sa desenez sticksurile in mod aleatoriu, cercurile jucatorilor, am reusit sa fac game logic-ul si sa salvez/incarc jocul prin functia save/load. Din pacate am un bug cand se termina jocul, nu apare pe ecran winner-ul, insa jocul se opreste, adica recunoaste ca cineva a castigat.

    -In drawing panel desenez sticks-urile aleatoriu cu functia paintSticks(), m-am inspirat din desenarea liniilor gri (asa ca pe slideuri).
    
    -Am facut o clasa node care ma ajuta sa determin nodurile adiacente. Nodurile adiacente le adaug in structura cand desenez sticksurile.
    
    -Partea un pic mai hard codata vine la drawStone() unde ma asigur ca stone-ul sa aiba coordonatele corecte, ca nodul pe care desenez sa fie valid si sa actualizez statusul nodului  ( validNode=false; ).
    
    -In clasa ControlPanel am adaugat si action events pentru butoanele load si save unde ma folosesc in principiu de functii din  java.io.File, javax.imageio.ImageIO  si swing.
    
