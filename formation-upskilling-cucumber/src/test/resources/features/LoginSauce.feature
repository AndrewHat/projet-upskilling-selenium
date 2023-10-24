#language: en

Feature: test de connexion sur Saucedemo
  login sur l'applciation web en entrant id et mdp

  @Let
 Scenario Outline: Cas nominal - connexion
    Given connect to "https://saucedemo.com"

