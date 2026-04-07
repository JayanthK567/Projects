class ResultProcessing:
    running = True
    def __init__ (self):
        self.students = dict()

    class Student:
        def __init__ (self, ID, name, maths, physics, chemistry):
            self.ID = ID
            self.name = name
            self.maths = maths
            self.physics = physics
            self.chemistry = chemistry

    def enterMarks(self):
        ID = input("Enter student ID: ")
        name = input("Enter the name: ")
        maths = int(input("Enter the maths marks: "))
        physics = int(input("Enter the physics marks: "))
        chemistry = int(input("Enter the chemistry marks: "))

        newStudent = self.Student(ID, name,maths,physics,chemistry)
        self.students[ID] = newStudent

    def viewResults(self):
        print("ID    name    maths    phy    chem    total    avg    grade")
        print("-"*70)
        
        for student in self.students:
            mathMarks= self.students.get(student).maths
            phyMarks= self.students.get(student).physics
            chemMarks= self.students.get(student).chemistry
            total = mathMarks + phyMarks + chemMarks
            avg = round(total/3,2)

            print(f" {student} \t {self.students.get(student).name} \t {mathMarks} \t {phyMarks} \t {chemMarks} \t {total} \t {avg} \t A")
    
    def updateMarks(self):
        ID = input("Enter student ID: ")
        if ID in self.students:
            self.enterMarks()
        else:
            print("ID does not exist")
    
    def start(self):
        while self.running:
            print()
            print("--- Exam Result Processing System ---")
            print("1.Enter Student Marks")
            print("2.View All Results")
            print("3.Update Student Marks")
            print("4.Display Class Stastics")
            print("5.Exit")
            choice = int(input("Enter your choice: "))

            if choice == 1:
                self.enterMarks()
            elif choice == 2:
                self.viewResults()
            elif choice == 3:
                self.updateMarks()
            elif choice == 4:
                self.displayStastics()
            elif choice == 5:
                break
            else: 
                print("Invalid input")

ResultProcessing().start()
