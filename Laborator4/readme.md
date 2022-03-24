# Homework:

Am o versiune a temei (in fisierul JGraphT.txt) unde m-am folosit de libraria  JGraphT  pentru arborele de cost minim, insa am vrut sa implementez varianta mea de algoritm pentru punctul bonus si pentru ca folosirea librarie necesita foarte multe linii pentru declaratii.

Clasa City pe care am creat-o nu contine decat o lista de strazi si doua functii *Greedy()* , *bestIntersection()* care ma ajuta la algoritmul de la sfarsit. Algoritmul nu functioneaza, da' niste erori, insa ideea din spate o consider buna. Algoritmul ia strazile cu lungimile mai mici si alege intersectiile care au potential mai mare. Cu un pic mai mult timp as fi putut plia algoritmul pentru partea de bonus. <br />

Clasa Intersection are de asemenea o lista de strazi si un camp visited pentru a ma ajuta la algoritmul de la final. <br />

Clasa Street are o lista de intersectii (capete),o functie *joinsThree()* care verifica daca nodul in care am ajuns are 3 (+1 strada care ajunge in nod) strazi care ies din el. De asemenea am generat un compareTo pentru a compara length-urile. <br />

In clasa Main declar strazile si intersectiile unde ma folosesc de clasa faker (din depencies) pentru a randomiza numele strazilor. <br />
