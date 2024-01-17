TD n°4
======

On se propose de modéliser un système de fichiers (en fait un système de chemins) et d'en réaliser une implémentation en Java.

Un système de fichiers est une structure **composite**, c'est -à-dire une structure arborescente avec des nœuds - les répertoires - et des feuilles - les fichiers.

Un répertoire :

- possède un nom
- connait son composant parent
- possède une liste de composants (fichiers et/ou répertoires) qui peuvent être ajoutés ou supprimés
- a une taille de 4096 octets

Un fichier :

- possède un nom
- connait son composant parent
- possède un contenu, qu'on modélisera comme une chaine de caractères
- a pour taille la longueur de la chaine de caractère de son contenu.

Il y a un nœud particulier qui n'a pas de parent, **la racine** du système de fichiers. N'importe quel élément du système de fichier doit pouvoir afficher son chemin absolu depuis cette racine. 

1 - Première implémentation
---------------------------

1. Proposez une modélisation de ce système de fichier avec le Design Pattern **Composite**.
2. Implémentez ce patron en java en accord avec cette classe :

```java
public class FileSystem {

	public static void main(String[] args) {
		try {
			Root root = new Root();
			Path home = new Folder("home");
			Path me = new Folder("ak");
			Path readme = new File("README.md", "Contenu");

			root.add(home);
			home.add(me);
			me.add(readme);

			System.out.println("Chemin de la racine : " + root.getAbsolutePath());
			System.out.println("Chemin de home      : " + home.getAbsolutePath());
			System.out.println("Chemin de README.md : " + readme.getAbsolutePath());
		}
		catch( Exception e ) {
			System.out.println(e);
		}
	}

}
```

qui doit produire la sortie suivante :

```shell
$ java filesystem.FileSystem
Chemin de la racine   : [Root] 
Chemin de home        : [Root] /home
Chemin de A31-td4.dia : [Root] /home/ak/README.md
```

2 - Utilitaire
--------------

On se propose de créer une "classe utilitaire" `PathService` qui permet d'obtenir des informations sur des éléments du système de fichier. Voici les 4 méthodes à implémenter :

3. La méthode `public static Integer du( Path path )` retourne la taille cumulée de `path` et tous ses descendants.
4. La méthode `public static String ls( Path path )` liste tous les fichiers et répertoires enfants de `path`.
5. La méthode `public static String lsRecursive( Path path )` liste tous les fichiers descendants de `path`.
6. La méthode `public static String find( Path path, String pattern )` liste tous les fichiers et répertoires descendants de `path` dont le nom "match" l'expression régulière `pattern`.

L'exécution du programme suivant :

```java
public class FileSystem {
	public static void main(String[] args) {
		try {
			Root root = new Root();
			Path home = new Folder("home");
			Path me = new Folder("ak");
			Path readme = new File("README.md", "Contenu");
			Path js = new Folder("js");
			Path retraite = new File("retraite.md", "Se reposer");
			Path livres = new File("livres.md", "L'intégrale de Philip K. Dick.");
			Path swapfile = new File("swapfile");

			root.add(home);
			home.add(me);
			me.add(readme);
			home.add( js );
			js.add( retraite );
			js.add( livres );
			root.add( swapfile );

			System.out.println("Taille de README.md      : " + PathService.du( readme ));
			System.out.println("Taille de ak             : " + PathService.du( me ));
			System.out.println("Taille de root           : " + PathService.du( root ));

			System.out.println("Contenu de js            : " + PathService.ls( js ));
			System.out.println("Contenu de home          : " + PathService.ls( home ));
			System.out.println("Contenu de root          : " + PathService.ls( root ));

			System.out.println("Contenu récursif de js   : " + PathService.lsRecursive( js ));
			System.out.println("Contenu récursif de home : " + PathService.lsRecursive( home ));
			System.out.println("Contenu récursif de root : " + PathService.lsRecursive( root ));

			System.out.println("Find 'livres.md' in home : " + PathService.find( home, "livres.md" ));
			System.out.println("Find '*re*' in root      : " + PathService.find( root, "*re*" ));
		}
		catch( Exception e ) {
			System.out.println(e);
		}
	}
}
```

doit afficher ce résultat sur la sortie standard :

```bash
$ java FileSystem
Taille de README.md      : 7
Taille de ak             : 4103
Taille de root           : 16431
Contenu de js            : retraite.md livres.md 
Contenu de home          : ak js 
Contenu de root          : home swapfile 
Contenu récursif de js   : retraite.md livres.md 
Contenu récursif de home : README.md retraite.md livres.md 
Contenu récursif de root : README.md retraite.md livres.md swapfile 
Find 'livres.md' in home : [Root] /home/js/livres.md 
Find '*re*' in root      : [Root] /home/js/retraite.md [Root] /home/js/livres.md 
```

Bonus
-----

- Mettez en place une fabrique de chemins et modifiez la classe `FileSystem` en conséquence.
- Ajoutez à la classe `PathService` les méthodes `public static void makeFile( String name, Path dest )` et `public static void makeFolder( String name, Path dest )` qui créent respectivement un fichier et un répertoire `name` dans le répertoire `dest`. modifiez la classe `FileSystem` en conséquence.
- Ajoutez à la classe `PathService` la possibilité de déplacer des chemins dans un nouveau répertoire. Complétez la classe `FileSystem` pour tester cette fonctionnalité.