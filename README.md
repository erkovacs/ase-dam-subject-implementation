# ASE DAM Sample Exam Subject Implementation
## DAM Exam number 1
Develop an Android application tie managing the articles within a scientific journal. For that, class Article is defined, containing the following fields: title, .firstPage. last/'age, no/halms.,
Implement the following requirements:
1. Define n menu activity containing the buttons: "Add article", "Itst of articles". "Extract articles from JSON/XML", "Report", "About". (0.5 points)
2. When pressing the "About" button, it message with the name of the application's author is displayed (0.5 points), the author's name is saved in the resource file. (0.5 points)
3. When pressing "Add article" button, new activity is invoked. The activity allows the insertion °fall the fields of an article and, using a function, a new instance of the class Article is created and the object is saved in it collection. (1 point). An article object is saved only if all its fields arc correctly inserted and validated. Validations are performed upon the values entered by the user. If the values are incorrect, the user will receive n specific message. (1 point)
4. All the articles added within the previous activity are displayed in a list, using a different activity. This activity is available using the tnenu's button "List of articles". The points arc offered only if the elements inserted by the user in the previous task arc displayed. (1 point)
5. By selecting an article from the list it will allow the user to modify it. The modification is made in the previous activity used for adding an article. (1 point)
6. The application allows saving the articles found in the collection in a local database. To check if the items were saved is made by displaying them using the journal files (LogCat). (1.5 points)
7. From the first activity, using the "Report" button, a new activity is opened in which a chart is drawn. The chart displays the number of articles depending on the number of authors, how many articles have the same number of authors. (1.5 points)
8. Read the file found at the address: http://myjson.com/dpeuk  which contains JSON objects with values according to the Article class. Save the values to the collection previously created in the application. The operation is made by clicking on "Extract articles from JSON/XML" button. (1.5 points)

* Within the project, alt strings used in the interface are saved in the resource files ( -1 point, otherwise).
