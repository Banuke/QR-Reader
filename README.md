# QR-Reader

App developed to scan Aadhar card and display information
This is a modofied version of Google's mobile vision Barcode API

Current version stats:
  - Reads the QR code
  - Extracts the XML file data to local variables
  - Display the relative data in an informatic manner
  - Incase of scan error, Manual entry form activity created.
  - User inputs taken as required
  
 Functions to be implemented:
 1. Read JSON file via an URL to publish in a spinner(List view) element (in both Scanned result view and Manual entry form)
 2. Pass the data to Print function embedded in the POS terminal
 3. Button in camera view activity to turn ON/OFF flash
 
General Info:

- All required activity java files are in the path "QR-Reader/Barcode-Reader-master/app/src/main/java/com/notbytes/barcodereader"

- MainActivity.java - Consists of two buttons to launch the scanning activity or manual entry activity. onActivityResult() contains the barcode read result function.

- ManualEntryActivity.java - Displays the manual entry form view (includes the layout XML)

- ResultViewActivity.java - Displays the automatic capture results view (includes the layout XML)

- tourType.java and CountriesDetails.java consist of list of strings (array lists) that is called to publish the spinner as of current version.

Suggestions:

- Create a java file to read the JSON file in the URL (http://dev-agra.mpulsesandbox.com/api/getCountries) and add to an arraylist. Maker sure to capture both countrycode and countryname. 

- Replace the current spinner assignment in both ManualEntryActivity.java and ResultViewActivity.java to read the above arraylist

- Printer functions :NO CLUE

- A button is already created to switch ON/OFF and the function stops the application on click. (Reason: it calls a new camera session). This needs to be handled in ".\Barcode-Reader-master\barcode-reader\src\main\java\com\notbytes\barcode_reader\BarcodeReaderFragment.java" file under "setFlash()" function.

