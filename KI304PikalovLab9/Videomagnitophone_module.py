import Videoplayer_module

class Videomagnitophone(Videoplayer_module.Videoplayer):

    def __init__(self):
        super().__init__()
        self.recBool = False

    def StartRecording(self):
        if self.recBool:
            print("Recording already in progress")
        else:
            print("Recording started...")
            self.recBool = True

    def StopRecording(self):
        if self.recBool:
            print("Recording stopped")
            self.recBool = False
        else:
            print("Recording is off already")

    def SaveRecVid(self):
        if self._mode.getMode() and self.recBool:
            print("Enter new video name (without .mp4):")
            newvid = input()
            Videoplayer_module.Videoplayer.videos.append(newvid + ".mp4")
            print("Recorded video has been added")
        elif not self._mode.getMode():
            print("You need to turn device on before using any features")
        elif not self.recBool:
            print("The video isn't being recorded right now")
