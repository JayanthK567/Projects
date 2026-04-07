class ExpenseTracker:
    def __init__ (self):
        self.categories = dict()
        self.regular = dict()
        self.totalPrice = 0
        self.running = True

    class Item:
        def __init__(self, name, category, price):
            self.name = name
            self.category = category
            self.price = price

    def addExpense(self):
        name = input("Enter name of the item: ")
        category = input("Enter the category of the item: ")
        price = float(input("Enter the price of the item: "))
        newItem = self.Item(name,category,price)
        self.categories[newItem.category] = [newItem.name,newItem.price]
        self.regular[newItem.name] = newItem.price
        self.totalPrice += newItem.price
        print("Item successfully added!")
        
    
    def viewExpenses(self):
        for item in self.regular:
            print(item , self.regular.get(item))
    
    def totalSpending(self):
        print("total spending: ",self.totalPrice)
    
    def categoryWise(self):
        for item in self.categories:
            print(item, self.categories.get(item))

    def start(self):
        while self.running:
            print("")
            print("--- Personal Expense Tracker ---")
            print("1.Add Expense")
            print("2.View Expenses")
            print("3.Total Spending")
            print("4.Category-wise Spending")
            print("5.EXit")
            choice = int(input("Enter your choice: "))
            if choice == 1:
                self.addExpense()
            elif choice == 2:
                self.viewExpenses()
            elif choice == 3:
                self.totalSpending()
            elif choice == 4:
                self.categoryWise()
            elif choice == 5:
                break
            else:
                print("invalid input")

ExpenseTracker().start()
