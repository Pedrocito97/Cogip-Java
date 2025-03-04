# Cogip Project - Backend Documentation

## Introduction

Ce projet est une API REST développée avec Spring Boot, utilisant Spring Data JPA pour la gestion des entités et Jakarta Persistence API pour l'interaction avec la base de données.

### Technologies utilisées

- Java 17

- Spring Boot 3

- Spring Data JPA

- Jakarta Persistence API

- PostgreSQL

- Maven

## Structure du projet

Le projet est structuré selon une architecture MVC avec les composants suivants :

### 1. Controllers (Gestion des requêtes API)

ContactController.java : Gère les endpoints liés aux contacts.

CompanyController.java : Gère les endpoints liés aux entreprises.

InvoiceController.java : Gère les endpoints liés aux factures.

TypeController.java : Gère les endpoints liés aux types d'entreprises.

UserController.java : Gère les endpoints liés aux utilisateurs.

### 2. Services (Logique métier)

ContactService.java : Contient la logique de gestion des contacts.

CompanyService.java : Contient la logique de gestion des entreprises.

InvoiceService.java : Contient la logique de gestion des factures.

TypeService.java : Contient la logique de gestion des types d'entreprises.

UserService.java : Contient la logique de gestion des utilisateurs.

### 3. Repositories (Interaction avec la base de données)

CompanyRepository.java : Interface permettant de récupérer des entreprises depuis la base de données.

ContactRepository.java : Interface permettant de récupérer des contacts.

InvoicesRepository.java : Interface permettant de récupérer des factures.

TypeRepository.java : Interface permettant de récupérer des types d'entreprises.

UserRepository.java : Interface permettant de récupérer des utilisateurs.

### 4. Entités (Modèles de données)

Contact.java : Représente un contact associé à une entreprise.

Companies.java : Représente une entreprise.

Invoices.java : Représente une facture.

Types.java : Représente un type d'entreprise.

User.java : Représente un utilisateur.

### 5. DTOs (Data Transfer Objects)

Les DTOs permettent de transmettre des données entre le frontend et le backend sans exposer directement les entités :

ContactDto.java : Objet de transfert pour les contacts.

CompanyDto.java : Objet de transfert pour les entreprises.

CompanyGetDto.java : DTO pour récupérer des entreprises avec leurs types.

InvoicesDto.java : Objet de transfert pour les factures.

UserDto.java : Objet de transfert pour les utilisateurs.

Installation et Exécution

### 1. Prérequis

Java 17

Maven

PostgreSQL

### 2. Configuration de la base de données

Modifier le fichier application.properties ou application.yml pour ajouter les paramètres de connexion :

spring.datasource.url=jdbc:mysql://localhost:3306/cogip_db
spring.datasource.username=root
spring.datasource.password=motdepasse
spring.jpa.hibernate.ddl-auto=update

### 3. Compilation et exécution

mvn clean install
mvn spring-boot:run

API Endpoints

### 1. Contacts

POST /contact : Ajouter un contact

GET /contact : Récupérer tous les contacts

GET /contact/{id} : Récupérer un contact par ID

PUT /contact/{id} : Mettre à jour un contact

DELETE /contact/{id} : Supprimer un contact

### 2. Entreprises

POST /company : Ajouter une entreprise

GET /company : Récupérer toutes les entreprises

GET /company/{id} : Récupérer une entreprise par ID

PUT /company/{id} : Mettre à jour une entreprise

DELETE /company/{id} : Supprimer une entreprise

GET /company/{id}/invoices : Récupérer les factures d'une entreprise

GET /company/{id}/contact : Récupérer les contacts d'une entreprise

### 3. Factures

POST /invoice : Ajouter une facture

GET /invoice : Récupérer toutes les factures

GET /invoice/{id} : Récupérer une facture par ID

PUT /invoice/{id} : Mettre à jour une facture

DELETE /invoice/{id} : Supprimer une facture

### 4. Types d'Entreprises

GET /types/{id}/companies : Récupérer les entreprises par type


#### Améliorations Futures

✅ Gestion des exceptions avec @ControllerAdvice ✅ Ajout de Pageable pour la pagination des résultats ✅ Ajout de logs pour suivre les opérations ✅ Sécurisation des endpoints avec JWT et Spring Security