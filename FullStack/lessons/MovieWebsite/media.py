import webbrowser

class Movie():
    """
    this Class provide some videos of my Youtube channel
    """
    
    valid_ratings = ["G", "PG", "PG-13", "R"]

    def __init__(self, title, storyline, poster_image_url, trailer):
        self.title = title
        self.storyline = storyline
        self.poster_image_url = poster_image_url
        self.trailer_youtube_url = trailer

    def showTrailer(self):
        webbrowser.open(self.trailer_youtube_url)
