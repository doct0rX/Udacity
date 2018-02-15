import webbrowser

class Movie():
    def __init__(self, title, storyline, poster_image_url, trailer):
        self.title = title
        self.storyline = storyline
        self.poster_image_url = poster_image_url
        self.trailer_youtube_url = trailer

    def showTrailer(self):
        webbrowser.open(self.trailer_youtube_url)
