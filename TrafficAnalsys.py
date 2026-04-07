class TrafficAnalsys:
    running = True

    def __init__ (self):
        data = dict()

    def start(self):
        while self.running == True:
            print()
            print("--- Menu Display ---")
            print("1.Enter Traffic Data")
            print("2.View Traffic Data")
            print("3.Analyze Daily & Hourly Traffic")
            print("4.Identify Peak & Off-Peak Hours")
            print("5.Rank Days by Traffic Load")
            print("6.EXit")
            choice = int(input("Enter your choice: "))

            if choice == 1:
                self.enterData()
            elif choice == 2:
                self.viewData()
            elif choice == 3:
                self.analyze()
            elif choice == 4:
                self.getPeak()
            elif choice == 5:
                self.rank()
            elif choice == 6:
                break
            else: 
                print("Invalid input")
