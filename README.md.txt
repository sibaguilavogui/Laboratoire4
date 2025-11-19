README – Laboratoire 4 : Intégration via une interface REST

Cours : Architecture des logiciels (GEI311)
Étudiant : Guilavogui Siba
Code permanent : GUIS15049901

SECTION I — Résumé des modifications (Backend + UI + Client Java)

Ce laboratoire avait pour objectif d’intégrer une architecture applicative complète autour d’une API REST générée avec OpenAPI Generator, d’un backend Spring Boot, d’un client Java, et d’une interface web simple.

Les travaux réalisés couvrent trois volets distincts :

Partie métier (backend)

Partie interface client Java

Partie interface web (bonus)

Modifications apportées à la partie métier (Backend – API REST)

La base de l’API a été générée automatiquement à partir du fichier openapi.yaml.
Ensuite, plusieurs ajustements et corrections ont été effectués.

Ajustements dans les modèles :

Mise à jour des modèles Ticket, NewTicket, UpdateTicket et User.

Correction des propriétés du modèle UpdateTicket : status, priority, assignedUserId.

Suppression de méthodes obsolètes ou erronées générées par OpenAPI.

Endpoints validés :

GET /tickets

POST /tickets

PUT /tickets/{id}

GET /users

POST /users

Améliorations du service métier :

Gestion de l’assignation d’un utilisateur à un ticket.

Vérification des états possibles : OUVERT, ASSIGNE, VALIDATION, TERMINE.

Gestion de la priorité : BASSE, MOYENNE, HAUTE.

Stockage en mémoire via HashMap.

Configuration Spring Boot :

Application lancée via OpenApiGeneratorApplication.

Serveur Tomcat exposé sur http://localhost:8080
.

Ajout d’un fichier index.html comme page d’accueil (bonus).

Modifications apportées à la partie UI (Client Java)

Un client Java complet a été développé pour interagir avec l’API REST.

Le fichier ClientDemo.java démontre :

Le chargement des utilisateurs (GET /users).

La création d’un utilisateur (POST /users).

La création d’un ticket (POST /tickets).

La mise à jour d’un ticket (PUT /tickets/{id}).

L’affichage des résultats dans la console.

Configuration :

Utilisation de ApiClient pour définir la base URL.

Utilisation de UsersApi et TicketsApi.

Correction d’imports manquants et ajustement des modèles.

Modifications importantes :

Remplacement des méthodes incorrectes isBlank() ou setAssignedTo() par les bonnes propriétés.

Migration du projet vers Java 17.

Correction d’erreurs de génération du client OpenAPI.

Interface web (Bonus)

Une interface simple a été ajoutée afin d’obtenir les points bonus.

Accessible via :
http://localhost:8080/index.html

Fonctionnalités réalisées :

Bouton “Charger les tickets” (appel GET /tickets).

Formulaire de création de ticket (POST /tickets).

Affichage dynamique des résultats.

Appels AJAX via fetch().

Mise en page simple en HTML/CSS.

SECTION II — Leçons apprises

Génération automatique via OpenAPI
J’ai appris comment OpenAPI peut générer une grande partie du code, mais aussi comment corriger les erreurs de génération pour assurer une cohérence entre le backend, le client Java et l’interface web.

Configuration d’un projet multi-modules
J’ai pris en main la configuration de projets Spring Boot, Maven, et modules Java dans IntelliJ, ainsi que la gestion des SDK.

Communication client–serveur
J’ai compris comment structurer des appels HTTP, manipuler les objets JSON en Java, et diagnostiquer des erreurs de mapping.

Importance de la cohérence des modèles
Une simple différence de nom dans les propriétés des modèles peut briser l’intégration. Il faut que le contrat de l’API soit respecté partout.

Création d’une interface web basique
J’ai appris à utiliser fetch(), à manipuler des réponses JSON, et à intégrer une interface web basique avec un backend REST.

Architecture logicielle
J’ai mieux compris la séparation entre :

l’API

la logique métier

le client Java

la couche de présentation web
Chaque partie a un rôle clair dans l’architecture globale.

CONCLUSION

Ce laboratoire m’a permis de :

comprendre et intégrer une API REST complète,

utiliser OpenAPI pour générer du code client,

corriger et adapter le code généré,

développer un client Java fonctionnel,

créer une interface web simple pour démontrer les fonctionnalités,

assimiler une architecture distribuée complète.