# ATM-Interface
So this project is all about how to create an ATM interface
<p><strong>Web Development project ideas are popular in engineering students. As it is an only software-based project so no ope required additional hardware kits which are bit costly. Web applications are simple to understand but little difficult and complex to implement.</strong>&nbsp;</p>


<p>&nbsp;It can display all the functionalities that an actual ATM display does. To use into the system user need to enter a unique pin. If the user will enter the correct pin then only can see all other option. After entering the correct credentials, user can see their bank details like account balance, transaction, withdraw amount, deposit amount and Quit options. It mainly consists of 4-5 classes. This project is specially suitable for the second year and third-year students.</p>

<h4><strong>Technologies Used</strong></h4>
<p>JAVA</p>

<h4><strong>Project Implementation</strong></h4>
<ol>
<li>Here we are using<strong>&nbsp;Intellij Idea IDE</strong> for the Project Implementation.
<li>Initially create three classes I.e. User.java, Account. Java, Transaction.java. ,Bank.java ,ATM.java. We have to code simultaneously in these classes.</li>
 <li>Create string for firstName, lastName, uuid . Account in the User class. It is for the 1st page of the application login. Along with this, declare the name of bank, balance and User holder with ArrayList transaction in the Account class. Provide the same process for the transaction details in transaction class and link it back to Account class.</li>
  <li>After that jump to User class, in this create constructor user() to set the user’s name. You can use MessageDigest package to store the pin, so import requires packages for so. Create an object for MessageDigest. If got an exception then handle it by using try and catch blocks. In this step, you can create your own account.</li>
  <li>Then create a constructor called Account in Account class. It will contain the account holder name which will be added to the appropriate holder list. Then create the main method in user.java which adds and user account</li>
  <li>Create Bank class for the checking of the account details like userName with account details. It contains the authentication code for the user. If the pin inserted is equal to saved pin and matches to the holder name then you can use the account with user authentication.</li>
  <li>This class also contains the operations for the amount available in the account and all other as mentioned above</li>
  <li>Create ATM class for the interface. Here you have to add user details like first name, last name and pin.</li>
  </li>
</ol>

<h3><strong>Benefits of the project</strong></h3>
<p>Java Concept practice</p>
<p>Handling of many classes</p>
<p>Practice on actual IDE&nbsp;</p>

