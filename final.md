# Night At the Museum Individual Final
## Self Grade Assesment: 2.4/2.5

## Tech Documentation

### JSON character parser and database
- [Package](https://github.com/zenxha/musicgacha/blob/main/src/main/java/com/musicgacha/data/Chae.java) that parses, sorts, shuffles, all the possible characters by rarity.
- Allows for a simple one line [code]([url](https://github.com/zenxha/musicgacha/blob/main/src/main/java/com/musicgacha/controllers/RollController.java#L49)) that allows us to pass data into thymeleaf
- Allows us to [get]([url](https://github.com/zenxha/musicgacha/blob/main/src/main/java/com/musicgacha/data/Chae.java#L62-L73)) any character by id. Whch helps us with making a page for EVERY [character](https://github.com/zenxha/musicgacha/blob/main/src/main/java/com/musicgacha/controllers/RollController.java#L55)
