During the work on this project, the initial code was improved and extended.

First, the program was expanded within the same topic — charity and donations. New classes and connections between them were added so that donors can donate money to charity organizations.

To make the code more correct, getters and setters were added. This allows working with data safely without direct access to class fields.

An abstract parent class Person was created. The Donor class now inherits from it. This helped to organize the code better and avoid repetition.

The program now uses lists to store donations. With these lists, it is possible to:

filter donations by amount,

search donations by donor name,

sort donations by amount.

Methods toString(), equals(), and hashCode() were added.
They help to correctly display objects and compare them with each other.

A simple connection to a PostgreSQL database was added. The database tables have the same structure as the Java classes. The program can work with stored data.

The output of the program was improved. Information is now displayed in a clean and readable format.