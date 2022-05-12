#Homework:

Clasele entitate  au fost generate dupa o mapare a bazei de date. <br>
In pachetul Repository am pus clasele repository care extind clasa abstracta (ajutatoare) *AbstractRepository*. <br>
Repou-urile contin functii de findById, findByName, findAll si create. (In constructor se realizeaza se realizeaza setupping-ul cu EntityManagerFactorySingleton). <br>
In pachetul tools avem clasa ManagaData ca face import din fisierul "concap.csv" unde se afla date despre orase. <br>
In functia main este realizata si cronometrarea importului. <br>
