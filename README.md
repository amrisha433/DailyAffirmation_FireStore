# 🌸 Daily Affirmations App

A modern Android application built using **Kotlin**, **Jetpack Compose**, and **Firebase Firestore** that helps users create and manage positive daily affirmations. The app supports real-time cloud storage and provides a clean, user-friendly interface for adding, updating, and deleting affirmations.

---

## ✨ Features

* ➕ Add new affirmations
* 📖 View all saved affirmations
* ✏️ Edit existing affirmations
* 🗑️ Delete affirmations
* ☁️ Real-time Firebase Firestore integration
* 🏗️ MVVM Architecture
* 🎨 Modern Jetpack Compose UI
* 📭 Empty state support
* 🔄 Automatic UI updates using Firestore Snapshot Listener

---

## 🎨 Design Approach

I enjoy experimenting with different color palettes, layouts, and UI styles across my projects.
Instead of reusing the same design pattern, I customize each application's 
appearance to match its purpose and user experience. For the Daily Affirmations App,
I chose a soft pastel color scheme and clean layout to create a calm, positive, and encouraging environment for users.

---

## 📱 Screenshots

### Empty State
The initial screen displayed when no affirmations have been added yet.
This provides a clean and user-friendly experience while encouraging users to create their first affirmation.

<img width="240" height="509" alt="Screenshot 2026-06-15 at 11 50 50 AM" src="https://github.com/user-attachments/assets/0dcc5e6b-da8f-4377-b344-1ce7b23cfe7e" />

---

### Home Screen
The main screen of the application where users can view all their saved affirmations.
Users can easily add, edit, or delete affirmations through a simple and intuitive interface.


<img width="252" height="527" alt="Screenshot 2026-06-15 at 11 56 23 AM" src="https://github.com/user-attachments/assets/5e639105-ad6e-41f4-bf09-5e963116842e" />


---

### Edit Affirmation
A dialog interface that allows users to update existing affirmations.
Changes are instantly synchronized with Firebase Firestore and reflected in the UI.


<img width="237" height="514" alt="Screenshot 2026-06-15 at 11 54 41 AM" src="https://github.com/user-attachments/assets/aaea7215-f6bd-4ec7-aa47-4b8bf219503c" />

---

### Firebase Firestore Database
The cloud database used to store affirmation records in real time.
Each affirmation is saved as a Firestore document, enabling seamless CRUD operations.


<img width="892" height="300" alt="Screenshot 2026-06-15 at 11 56 46 AM" src="https://github.com/user-attachments/assets/336fe8eb-f655-4d9a-80eb-4c7d54ee42a6" />

---

## 🛠️ Tech Stack

* Kotlin
* Jetpack Compose
* Firebase Firestore
* Android ViewModel
* MVVM Architecture
* Material 3
* State Management

---

## 📂 Project Structure

```text
com.example.dailyaffirmationfirestore

├── Repository
│   ├── FireStoreRepository.kt
│   └── Affirmation.kt
│
├── viewmodel
│   └── ViewModelAffirmation.kt
│
├── ui
│   └── Screen
│       └── DisplayAffirmations.kt
│
└── Firebase Firestore
```

---

## 🚀 How It Works

1. User enters an affirmation.
2. The affirmation is saved to Firebase Firestore.
3. Firestore Snapshot Listener detects changes.
4. UI automatically updates with the latest data.
5. Users can edit or delete affirmations at any time.

---

## 🏗️ Architecture

```text
UI (Jetpack Compose)
        ↓
ViewModel
        ↓
Repository
        ↓
Firebase Firestore
```

---

## 🔥 Firebase Integration

This project uses **Firebase Firestore** as a cloud database to store affirmations.

Implemented operations:

* Create Affirmation
* Read Affirmations
* Update Affirmation
* Delete Affirmation

All changes are synchronized in real time using Firestore Snapshot Listeners.

---

## 🎯 Learning Outcomes

Through this project, I practiced:

* Firebase Firestore Integration
* CRUD Operations
* MVVM Architecture
* Repository Pattern
* State Management in Jetpack Compose
* Real-Time Data Synchronization
* Modern Android UI Development
* Android Application Architecture

---

## 🌟 Future Improvements

* User Authentication
* Dark Mode Support
* Search Affirmations
* Categories & Tags
* Daily Reminder Notifications
* Offline Caching

---

## 👩‍💻 Author

**Amrisha Maurya**

Android Developer | Kotlin | Jetpack Compose | Firebase

---

⭐ If you like this project, consider giving it a star!
