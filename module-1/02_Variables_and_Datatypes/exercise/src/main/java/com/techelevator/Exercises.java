package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsInWoods = 3;
		int raccoonsThatGoHome = 2;
		int raccoonsLeft = raccoonsInWoods - raccoonsThatGoHome;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int flowers = 5;
		int bees = 3;
		int beesLessThanFlowers = flowers - bees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int lonelyPigeon = 1;
		int incomingPigeons = 1;
		int pigeonsTogether = lonelyPigeon + incomingPigeons;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int sittingOwls = 3;
		int incomingOwls = 2;
		int totalSittingOwls = sittingOwls + incomingOwls;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int workingBeavers = 2;
		int swimmingBeavers = 1;
		int beaversLeft = workingBeavers - swimmingBeavers;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int sittingToucans = 2;
		int incomingToucans = 1;
		int totalToucans = sittingToucans + incomingToucans;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrels = 4;
		int nutsAvailable = 2;
		int unluckySquirrels = squirrels - nutsAvailable;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double hiltsPurse = quarter + dime + (nickel * 2);

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int brierMuffins = 18;
		int macAdamsMuffins = 20;
		int flanneryMuffins = 17;
		int totalGrade1Muffins = brierMuffins + macAdamsMuffins + flanneryMuffins;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double yoyoCost = 0.24;
		double whistleCost = 0.14;
		double hiltSpent = yoyoCost + whistleCost;


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int largeMarsh = 8;
		int smallMarsh = 10;
		int totalMarsh = largeMarsh + smallMarsh;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int hiltSnowInches = 29;
		int brecknockSnowInches = 17;
		int moreHiltThanBrecknock = hiltSnowInches - brecknockSnowInches;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */

		double hiltStartPurse = 10.0;
		double toyTruckCost = 3.0;
		double pencilCaseCost = 2.0;
		double hiltLeftPurse = hiltStartPurse - toyTruckCost - pencilCaseCost;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int joshMarbles = 16;
		int lostMarbles = 7;
		int marblesLeft = joshMarbles - lostMarbles;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int hasSeashells = 19;
		int totalSeashells = 25;
		int seashellsLeftToFind = totalSeashells - hasSeashells;

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int bradBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = bradBalloons - redBalloons;

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksStart = 38;
		int booksBeingPlaced = 10;
		int booksOnShelf = booksStart + booksBeingPlaced;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int beeLegs = 6;
		int eightBeesLegs = beeLegs * 8;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double coneCost = .99;
		double twoCones = coneCost * 2;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int totalRocksNeeded = 125;
		int rocksOnHand = 64;
		int rocksNeededLeft = totalRocksNeeded - rocksOnHand;

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int hiltMarbles = 38;
		int hiltLostMarbles = 15;
		int hiltMarblesLeft = hiltMarbles - hiltLostMarbles;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int milesAwayToConcert = 78;
		int milesAtGasStop = 32;
		int milesLeftToDrive = milesAwayToConcert - milesAtGasStop;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */

		int satMorningShoveling = 90;
		int satAfternoonShoveling = 45;
		int totalMinutesShoveling = satMorningShoveling + satAfternoonShoveling;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		int hiltsHotDogs = 6;
		double hotDogCost = 0.50;
		double totalDogCost = hiltsHotDogs * hotDogCost;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		int hiltCentsHas = 50;
		int pencilCostCents = 7;
		int canBuyPencils = hiltCentsHas / pencilCostCents;

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double kateCash = 1.00;
		double candyCost = 0.54;
		double changeForKate = kateCash - candyCost;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int treesStart = 13;
		int treesToPlant = 12;
		int totalTrees = treesStart + treesToPlant;


        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int hoursPerDay = 24;
		int daysLeftToSeeGranny = 2;
		int hoursLeftToSeeGranny = hoursPerDay * daysLeftToSeeGranny;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int kimsCousins = 4;
		int gumPiecesEach = 5;
		int gumNeeded = kimsCousins * gumPiecesEach;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double danWalletStart = 3.00;
		double candyBarCost = 1.00;
		double moneyLeftForDan = danWalletStart - candyBarCost;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int boatsInLake = 5;
		int peopleInBoats = 3;
		int totalPeopleInBoats = boatsInLake * peopleInBoats;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int ellenLegos = 380;
		int lostLegos = 57;
		int legosLeft = ellenLegos - lostLegos;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int totalMuffinsForArthur = 83;
		int muffinsBaked = 35;
		int muffinsLeftToBake = totalMuffinsForArthur - muffinsBaked;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willysCrayons = 1400;
		int lucyCrayons = 290;
		int moreWillyThanLucy = willysCrayons - lucyCrayons;

		/* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int stickersPerPage = 10;
		int numPages = 22;
		int numStickers = stickersPerPage * numPages;

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		double totalCupcakes = 100.0;
		double hungryChildren = 8.0;
		double cupcakesPerKid = totalCupcakes / hungryChildren;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */

		int totalCookiesMade = 47;
		int numCookiesPerJar = 6;
		int remainderCookies = totalCookiesMade % numCookiesPerJar;


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */

		int totalCroissantsMade = 59;
		int numNeighbors = 8;
		int croissantsLeftForMarian = totalCroissantsMade % numNeighbors;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int desiredNumCookies = 276;
		int cookiesPerTray = 12;
		int traysNeeded = desiredNumCookies / cookiesPerTray;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		int totalMiniPretzels = 480;
		int pretzelsPerServing = 12;
		int totalServingsMade = totalMiniPretzels / pretzelsPerServing;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int totalLemCupcakes = 53;
		int lemCupcakesLeftHome = 2;
		int boxOfLemCupcakes = 3;
		int boxesGivenAway = (totalLemCupcakes - lemCupcakesLeftHome) / boxOfLemCupcakes;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int carrotSticks = 74;
		int carrotPeople = 12;
		int remainderCarrots = carrotSticks % carrotPeople;


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int totalTeddys = 98;
		int teddysPerShelf = 7;
		int totalShelvesFilled = totalTeddys / teddysPerShelf;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int totalPhotos = 480;
		int photosPerAlbum = 20;
		int albumsNeeded = totalPhotos / photosPerAlbum;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int totalTradingCards = 94;
		int cardsPerFullBox = 8;
		int cardBoxesFilled = totalTradingCards / cardsPerFullBox + 1;
		int cardsInLastBox = totalTradingCards % cardsPerFullBox;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int booksInLibrary = 210;
		int goodShelves = 10;
		int booksPerShelf = booksInLibrary / goodShelves;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		double bakedCroissants = 17.0;
		double numGuests = 7.0;
		double croissantsPerGuest = bakedCroissants / numGuests;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */

		double billRoomsPerHour = 1 / 2.15;
		double jillRoomsPerHour = 1 / 1.90;
		double combinedTimePerRoom = 1 / (billRoomsPerHour + jillRoomsPerHour);
		double timeToPaintFive = combinedTimePerRoom * 5;

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */

		String firstName = "Grace";
		String lastName = "Hopper";
		String middleInitial = "B";
		String fullName = lastName + ", " + firstName + " " + middleInitial +".";



	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */

		int distanceNYToChicago = 800;
		int distanceTraveled = 537;
		int percentTraveled = (distanceTraveled * 100) / distanceNYToChicago;
	}

}
