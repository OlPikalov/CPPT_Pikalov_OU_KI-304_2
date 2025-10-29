class Volume:
    def __init__(self, volume: int):
        self.volume = volume

    def Print(self):
        print("Volume level is: " + str(self.volume))

    def setVolume(self, volume: int):
        self.volume = volume

    def getVolume(self):
        return self.volume
