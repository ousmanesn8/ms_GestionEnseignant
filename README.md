# ms_GestionEnseignant
-Micro-service gestion des Enseignants

	-Installer maven
	-Installer docker

-Se placer à la racine du projet et taper : 
	- mvn package
	- docker build -t enseignant-jdbc .
-Ensuite :

	-docker run --name enseignant-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=enseignantdb -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6

	-docker run -p 9191:9191 --name enseignant-jdbc --link enseignant-mysql:mysql -d enseignant-jdbc

-Lancer Postman

	-Aller à : "localhost:9191/enseignants/all" pour afficher les enseignants ne pas oublier de choisir "GET"
	-Aller à : "localhost:9191/enseignants/add" pour insérer un enseignant ne pas oublier de choisir "POST"
	-Aller à : "localhost:9191/enseignants/update/{id}"  pour modifier un enseignant ne pas oublier de choisir "PUT" en precissant les modification
	-Aller à : "localhost:9191/enseignants/delete/{id}" pour supprimer un enseignant ne pas oublier de choisir "DEL"
	-Aller à : "localhost:9191/enseignants/{id}" pour retrouver un enseignant par son id methode "GET"
