import Volume
import Power
import Mode


class Videoplayer:
    videos = [
        "The_Matrix.mp4", "Inception.mp4", "Interstellar.mp4",
        "The_Dark_Knight.mp4", "Avatar.mp4", "Titanic.mp4",
        "Jurassic_Park.mp4", "The_Godfather.mp4",
        "Forrest_Gump.mp4", "The_Avengers.mp4"
    ]

    def __init__(self):
        self._volume = Volume.Volume(20)
        self._power = Power.Power(False)
        self._mode = Mode.Mode(False)
        self.stat = None
        self.videoStat = False
        self.currentVideo = ""
        self.screen = None

    def Stats(self):
        self._volume.Print()
        self._mode.Print()
        self._power.Print()
        print("Amount of videos:", len(Videoplayer.videos))

    def Plug_unplug(self):
        if self._power.getPower():
            self._power.setPower(False)
            self._mode.setMode(False)
            print("Power: off")
        else:
            self._power.setPower(True)
            print("Power: on")

    def Turn_OnOff(self):
        if self._power.getPower():
            if self._mode.getMode():
                self._mode.setMode(False)
                print("Mode: off")
            else:
                self._mode.setMode(True)
                print("Mode: on")
        else:
            self._mode.setMode(False)
            print("Unable to turn on due to lack of power")

    def ChangeVolume(self):
        if self._mode.getMode():
            print("Current volume:", self._volume.getVolume(), '%')
            volume = int(input("New volume: "))
            self._volume.setVolume(volume)
        else:
            print("You need to turn device on before using any features")

    def AvailableVideos(self):
        if self._mode.getMode():
            for string in Videoplayer.videos:
                print(string)
            print("Total amount:", len(Videoplayer.videos))
        else:
            print("You need to turn device on before using any features")

    def AddVideo(self):
        if self._mode.getMode():
            newvid = input("Enter new video name (without .mp4): ")
            Videoplayer.videos.append(newvid + ".mp4")
            print("Video has been added")
        else:
            print("You need to turn device on before using any features")

    def RemoveVideo(self):
        if self._mode.getMode():
            for i, video in enumerate(Videoplayer.videos):
                print(f"{i + 1}: {video}")
            input_val = input("Enter the integer or name of the video (without .mp4) to remove: ")
            if input_val.isdigit():
                delvid = int(input_val)
                if 1 <= delvid <= len(Videoplayer.videos):
                    print("Video removed:", Videoplayer.videos[delvid - 1])
                    Videoplayer.videos.pop(delvid - 1)
                else:
                    print("Invalid number.")
            else:
                vidname = input_val + ".mp4"
                if vidname in Videoplayer.videos:
                    Videoplayer.videos.remove(vidname)
                    print("Video has been removed:", input_val)
                else:
                    print("Video hasn't been found:", input_val)
        else:
            print("You need to turn device on before using any features")

    def PlayVideo(self):
        if self._mode.getMode():
            self.videoStat = True
            print("Choose a video to play (integer or name without .mp4)")
            for i, video in enumerate(Videoplayer.videos):
                print(f"{i + 1}: {video}")
            input_val = input().strip()
            if input_val.isdigit():
                vidIndex = int(input_val)
                if 1 <= vidIndex <= len(Videoplayer.videos):
                    self.currentVideo = Videoplayer.videos[vidIndex - 1]
                    print("Video playing:", self.currentVideo)
                else:
                    self.videoStat = False
                    print("Invalid number.")
            else:
                videoName = input_val + ".mp4"
                if videoName in Videoplayer.videos:
                    self.currentVideo = videoName
                    print("Video playing:", videoName)
                else:
                    self.videoStat = False
                    print("Video hasn't been found:", videoName)
        else:
            print("You need to turn device on before using any features")

    def checkCurVid(self):
        print("Video playing:", self.currentVideo)

    def GoToMainMenu(self):
        self.videoStat = False

    def getVideoStat(self):
        return self.videoStat