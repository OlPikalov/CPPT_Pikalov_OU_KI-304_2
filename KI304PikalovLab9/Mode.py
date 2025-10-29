class Mode:
    def __init__(self, mode: bool):
        self.mode = mode

    def Print(self):
        if self.mode : print("Mode is: on")
        else: print("Mode is: off")

    def setMode(self, mode: bool):
        self.mode = mode

    def getMode(self):
        return self.mode
