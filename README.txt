*****************************************************
*		 	ECLIPSE 		    *
*****************************************************
Importer le projet dans Eclipse : 

Se placer sur le menu principal puis : 
	File > Import > Maven > Existing Maven Project

-> Une fenêtre s'affiche, sélectionner le dossier racine du projet 
-> Eclipse doit trouver le fichier POM.xml 

-> Appuyez sur "terminer"


*****************************************************
*		 	INTELLIJ		    *
*****************************************************
Lancement depuis IntelliJ : 

Si vous ouvrez le programme depuis IntelliJ il faut importer 
la librairie processing, pour ce faire : 

	Dans IntelliJ :
		-> Faire Shift + Ctrl + Alt + S
		-> Dans la fenêtre qui s'ouvre : 
			-> Libraries 
			-> + 
			-> Java 
			-> Sélectionner le JAR nommé "core"
		     	   (Il se trouve dans le répertoire lib du projet) 
			-> Apply 
			-> OK ;

Pour configurer les accès à la BDD : 

	Se déplacer dans le répertoire config, ouvrir le fichier config.conf
	 rentrez les informations propres à votre BDD.