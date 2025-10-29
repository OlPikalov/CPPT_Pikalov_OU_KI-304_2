import  Videomagnitophone_module

if __name__ == "__main__":
    mag = Videomagnitophone_module.Videomagnitophone()
    mag.Turn_OnOff()
    mag.Plug_unplug()
    mag.Turn_OnOff()
    mag.ChangeVolume()
    mag.AvailableVideos()
    mag.AddVideo()
    mag.RemoveVideo()
    mag.StartRecording()
    mag.SaveRecVid()
    mag.StopRecording()
    mag.Stats()
