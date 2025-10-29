class Power:
    def __init__(self, power: bool):
        self.power = power

    def Print(self):
        if self.power: print("Power is: on")
        else: print("Power is: off")

    def setPower(self, power: bool):
        self.power = power

    def getPower(self):
        return self.power
