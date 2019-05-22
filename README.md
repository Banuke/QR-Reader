# QR-Reader

App developed to scan Aadhar card and display information
This is a modofied version of Google's mobile vision Barcode API

Purpose (Client's requirement): 
An app to read Aadhar card and pass these values to a form based view. This is to be used at the entrace of a "Place of Worship" to identify and keep record of the personnel. 
However, some fields that are not embedded in the QR code needs to be given the ability to enter manually (mobile no, country etc...)In case, if the QR isn't read, the app should provide with a complete manual entry form based view to enter the data (Sample screenshots of the dekstop and mobile application is attached in root directory). 
Once the details are entered (manually or automatically), a submission to
  1. Print the data (in form of a receipt) through inbuilt print functionaly in mobile POS terminal
  2. Parse the collected data under a unique barcode for the current session into the database.

Current version stats:
======================
  - Reads the QR code
  - Extracts the XML file data to local variables
  - Display the relative data in an informatic manner
  - Incase of scan error, Manual entry form activity created.
  - User inputs taken as required
  
Functions to be implemented:
===========================
 1. Read JSON file via an URL to publish in a spinner(List view) element in ONLY Manual entry form (Result view means Aadhar card is properly scanned, hence default value set to India)
 2. Pass the data to Print function embedded in the POS terminal
 3. Pass the information collected into the database
 4. Button in camera view activity to turn ON/OFF flash
 
General Info:

- All required activity java files are in the path "QR-Reader/Barcode-Reader-master/app/src/main/java/com/notbytes/barcodereader"

- MainActivity.java - Consists of two buttons to launch the scanning activity or manual entry activity. onActivityResult() contains the barcode read result function.

- ManualEntryActivity.java - Displays the manual entry form view (includes the layout XML)

- ResultViewActivity.java - Displays the automatic capture results view (includes the layout XML)

- tourType.java and CountriesDetails.java consist of list of strings (array lists) that is called to publish the spinner as of current version.

Suggestions:

- Create a java file to read the JSON file in the URL (http://dev-agra.mpulsesandbox.com/api/getCountries) and add to an arraylist. Maker sure to capture both countrycode and countryname (code for DB and name for list view). 

- Replace the current spinner assignment in both ManualEntryActivity.java and ResultViewActivity.java to read the above arraylist

- Printer functions :NO CLUE

- A button is already created to switch ON/OFF and the function stops the application on click. (Reason: it calls a new camera session). This needs to be handled in ".\Barcode-Reader-master\barcode-reader\src\main\java\com\notbytes\barcode_reader\BarcodeReaderFragment.java" file under "setFlash()" function.

