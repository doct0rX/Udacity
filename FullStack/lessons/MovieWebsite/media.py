import webbrowser
class Movie():
    def __init__(self, title, storyline, posterImage, trailer):
        self.title = title
        self.storyline = storyline
        self.posterImage = posterImage
        self.trailer = trailer

    def showTrailer(self):
        webbrowser.open(self.trailer)
