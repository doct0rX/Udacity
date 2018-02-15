import media
import fresh_tomatoes

decipherX = media.Movie("decipherX",
                        "an application to remove watermark",
                        "./photos/x.png",
                        "https://www.youtube.com/watch?v=XomH8rBJfUk")

# print(toyStory.storyline)
# toyStory.showTrailer()

diceX = media.Movie("diceX",
                        "an application -> DiceX ###",
                        "./photos/dice.jpg",
                        "https://www.youtube.com/watch?v=DdH3WCOT1x0")


iqx = media.Movie("iqx",
                        "an application -> IQ",
                        "./photos/iq.jpg",
                        "https://www.youtube.com/watch?v=ezFD-FELtXE")

movies = [decipherX, diceX, iqx]
fresh_tomatoes.open_movies_page(movies)