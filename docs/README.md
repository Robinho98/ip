# **User Guide**
Duke is a chat bot that can help you manage your daily tasks.

![Image of Screenshot](Screenshot.png)

## **Features** 

Duke is capable fo creating tasks, such as:

* ToDo
* Deadline
* Event

Duke can also help you manage these tasks via these commands:

* Done
* Delete
* List
* Find
* Tag
* Bye

## **Usage** 

Type your desired command into the text box of Duke. 

## **Commands**

### 1. Adding a ToDo task

**Usage:**
```
todo <description name>
```

Duke will add a todo task with the description name

**Example:** todo homework

### 2. Adding a Deadline task

**Usage:** 
```
deadline <description name> /by <date in YYYY-MM-DD format>
```

Duke will add a deadline task with the description name and a date it is due by

**Example:** deadline watch lecture /by 2020-09-20

### 3. Adding an Event task

**Usage:** 
```
event <description name> /at <date in YYYY-MM-DD format>
```

Duke will add an event task with the description name and a date it is held at

**Example:** event concert /at 2020-09-13

### 4. Mark task as done

**Usage:** 
```
done <task index in list>
```

Duke will mark the selected task as done. Task index refers to the position of the task in the list.
If task index is invalid, such as if it is 0 or smaller, Duke will return "No such task found!"

**Example:** done 3

### 5. Delete Task

**Usage:** 
```
delete <task index in list>
```

Duke will delete the selected task, and . Task index refers to the position of the task in the list.
If task index is invalid, such as if it is 0 or smaller, Duke will return "This task does not exist!"

**Example:** delete 2

