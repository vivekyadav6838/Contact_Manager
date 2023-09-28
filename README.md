# Contact Manager App

## Introduction

Welcome to the Contact Manager app! This Android application is designed to help users easily store, update, and delete important contact information. It is built using Kotlin and XML in Android Studio and follows the MVVM (Model-View-ViewModel) architecture. The app leverages ROOM to manage the data effectively.

## Features

- **Add Contact**: Users can easily add new contacts by providing details such as name, phone number, email, and any additional information.

- **Update Contact**: Edit existing contact information, making it easy to keep contact details up-to-date.

- **Delete Contact**: Remove contacts that are no longer needed.

- **View Contact List**: Display a list of all stored contacts for quick reference.

## Installation

To use the Contact Manager app, follow these steps:

1. Clone this repository to your local machine:

   ```
   git clone https://github.com/vivekyadav6838/contact_Manager
   ```

2. Open the project in Android Studio.

3. Build and run the app on an Android emulator or a physical device.

## Dependencies

The Contact Manager app uses the following major dependencies:

- Kotlin: The primary programming language used for Android development.

- AndroidX: AndroidX libraries for modern Android development.

- ROOM Database: For data storage and management.

- ViewModel: Part of the Android Architecture Components, used to manage UI-related data.

- LiveData: Also part of the Android Architecture Components, used for observing data changes in real-time.<img width="1440" alt="Screenshot 2023-09-29 at 12 32 05 AM" src="https://github.com/vivekyadav6838/Contact_Manager/assets/59759496/ed9545d8-1717-408d-95a7-454051d5b8bd">


## Architecture

The app follows the MVVM (Model-View-ViewModel) architectural pattern:

- **Model**: Represents the data and business logic of the app. In this case, it includes the data entities and the ROOM database.

- **View**: Represents the UI components, including XML layout files and activities/fragments.

- **ViewModel**: Serves as a bridge between the Model and View. It holds and manages the UI-related data, ensuring separation of concerns.

## Usage

1. **Adding a Contact**:
   - Open the Contact Manager app.
   - Tap on Text are file to add a new contact.
   - Fill in the contact details (name, Email,etc).
   - Tap the "Save" button to add the contact to the list.

2. **Updating a Contact**:
   - Open the Contact Manager app.
   - Tap on an existing contact from the list.
   - Edit the contact details as needed.
   - Tap the "Save" button to update the contact.

3. **Deleting a Contact**:
   - Open the Contact Manager app.
   - Long-press on a contact from the list.
   - Confirm the deletion when prompted.

4. **Viewing Contacts**:
   - Open the Contact Manager app to see the list of stored contacts.

## Contribution

Contributions to this project are welcome! If you have any suggestions, bug reports, or feature requests, please create an issue in the GitHub repository or submit a pull request.



## Contact

If you have any questions or need further assistance, you can contact the developer at (mailto:vivekyadav6838@gamil.com).

Thank you for using the Contact Manager app! We hope it helps you manage your important contacts efficiently.
