# Programowanie Aplikacyjne (PAP) - 21Z - Zespół 7

# Członkowie zespołu

- ### **Adam Sudoł**
- ### **Bartłomiej Krawczyk**
- ### **Kamil Sulkowski**
- ### **Karol Rogoziński**

# Wymagania i założenia projektu

### Zadanie polega na napisaniu systemu do obsługi restauracji.

### W tym:

<!--
- baza danych - sql - oracle
- aplikacja desktopowa dla kucharzy - swing
- aplikacja mobilna dla kelnerów - android
- api, które będzie przekazywało dane między bazą danych, a frontem - spring boot
- ? aplikacja dla admina ? - swing lub bez tego ręcznie w bazie danych będzie można wprowadzać zmiany
- ? aplikacja dla zaopatrzyciela ? - swing lub bez tego - wgląd do bazy danych
-->

## Aplikacja desktopowa

Aplikacja desktopowa dla kucharzy napisana w języku Java z interfejsem graficznym napisanym przy użyciu biblioteki Swing

### Funkcjonalność:

- dla kucharzy

  - wyświetlanie oczekujących zamówień
  - wyświetlanie informacji o daniach (składniki, przepis, kategoria itp.)
  - możliwość edycji statusu dania
  - ??? możliwość przypisania siebie do wykonania dania ???
  - edycja ilości składników na składzie po wykonanym zamówieniu (możliwe, że automatycznie w bazie danych)

- do inwentarzu \*\*OPTIONAL\*\*

  - wyświetlanie danych o zaopatrzeniu
  - wyświetlanie czego jest mało
  - aktualizacja ilości składników

- dla admina \*\*OPTIONAL\*\*

  - crud składniki / produkty
  - crud dania
  - crud pracownicy
  - crud stoliki
  - crud kategorie

## Aplikacja mobilna

Aplikacja mobilna dla kelnerów napisana w języku Java na telefony Android.

### Funkcjonalność:

- dla kelnerów
  - dodawanie nowego rachunku
  - przeglądanie kategorii dań
  - przeglądanie dostępnych dań w ramach kategorii
  - składanie zamówień na dania w ramach danego rachunku

## Baza danych

Centralna baza danych Oracle

## Api

Serwer napisany w języku Java przy wykorzystaniu framework Spring Boot.

### Funkcjonalność:

- ma służyć jako pośrednik między aplikacjami wykorzystywanymi przez pracowników, a bazą danych
- głównym zadaniem jest mapowanie obiektów z relacyjnej bazy danych na javowe obiekty i na odwrót
