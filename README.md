# ProgettoBevandeJava_DTA

# ☕ Sistema di Personalizzazione Bevande - Java

## 📌 Descrizione del progetto

Questo progetto simula un sistema di ordinazione bevande (distributore).
L’utente può selezionare una bevanda base e arricchirla con ingredienti extra dinamici (decorazioni), fino a ottenere un ordine finale con costo e descrizione personalizzati 

Il sistema è strutturato seguendo diversi **Design Pattern** per garantire modularità, estendibilità e separazione delle responsabilità.

---

# 🧠 Design Pattern utilizzati

## 1. 🧩 Decorator Pattern

### 📍 Scopo
Permette di aggiungere dinamicamente ingredienti extra a una bevanda senza modificare le classi base.

### 📦 Struttura

- `Bevanda` → Interfaccia base
- `Caffe`, `Te`, `CioccolataCalda` → Componenti concreti
- `DecoratorBevanda` → classe astratta decoratore
- Decoratori concreti:
  - `DecoratorLatte`
  - `DecoratorZucchero`
  - `DecoratorCacao`
  - `DecoratorPanna`
  - `DecoratorCannella`

### ⚙️ Funzionamento

Ogni decoratore:
- Riceve una `Bevanda`
- Modifica:
  - `getDescrizione()`
  - `getCosto()`

Esempio:
Bevanda bevanda = new Caffe();
bevanda = new DecoratorLatte(bevanda);
bevanda = new DecoratorZucchero(bevanda);

➡️ Risultato: bevanda con descrizione e prezzo modificati dinamicamente.

---

## 2. 🧵 Singleton Pattern

### 📍 Scopo
Garantire una sola istanza per la gestione degli ordini.

### 📦 Classe coinvolta
- `S_GestoriOrdini`

### ⚙️ Funzionamento

- Costruttore privato
- Istanza statica unica
- Accesso tramite:
S_GestoriOrdini.getIstanza();

### 📌 Responsabilità
- Salvare storico ordini
- Confermare ordini
- Visualizzare storico

---

## 3. 🎯 Strategy Pattern

### 📍 Scopo
Applicare dinamicamente diversi tipi di sconto.

### 📦 Struttura

- `StrategySconti` → interfaccia
- `StrategyNormali` → nessuno sconto
- `StrategyStudente` → sconto 20%

### ⚙️ Funzionamento

macchinetta.setStrategy(new StrategyStudente());

➡️ Il prezzo finale viene calcolato dinamicamente.

---

## 4. 🏛 Facade Pattern

### 📍 Scopo
Fornire un’interfaccia semplificata per gestire la logica del bar.

### 📦 Classe
- `BarFacade`

### ⚙️ Responsabilità

- Creazione bevande base
- Interazione con Singleton
- Gestione archiviazione ordini

---

# 🧱 Architettura generale (MVC + Pattern)

## 📁 Controller
MacchinettaController
- Gestisce input utente
- Coordina View e Model
- Applica Strategy
- Usa Facade per logica business

---

## 📁 Model

- Bevande base: Caffe, Te, CioccolataCalda
- Decorator: ingredienti extra
- Singleton: S_GestoriOrdini
- Facade: BarFacade

---

## 📁 View

MacchinettaView
- Menu
- Stampe
- Storico ordini
- Bevanda corrente

---

## 📁 Main

EsercizioMacchinetta
- Loop principale
- Input utente
- Collegamento controller

---

# 🔄 Flusso del programma

1. Creazione bevanda base
2. Aggiunta ingredienti (Decorator)
3. Visualizzazione bevanda
4. Conferma ordine
5. Applicazione Strategy (sconti)
6. Salvataggio nel Singleton
7. Visualizzazione storico

---

# 🚀 Punti di forza

- Uso di più Design Pattern
- Struttura MVC chiara
- Codice estendibile
- Separazione responsabilità

---
