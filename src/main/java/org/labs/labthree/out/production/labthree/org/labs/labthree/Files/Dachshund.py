class Dachshund:
    def __init__(self, name, age, color):
        self.name = name
        self.age = age
        self.color = color

    def bark(self):
        print(f"{self.name}, the Dachshund, is barking!")

    def display_info(self):
        print(f"Name: {self.name}")
        print(f"Age: {self.age} years")
        print(f"Color: {self.color}")

my_dachshund = Dachshund("Buddy", 5, "Brown")

my_dachshund.bark()
my_dachshund.display_info()
