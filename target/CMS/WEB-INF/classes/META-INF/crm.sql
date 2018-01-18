




INSERT INTO `authors` VALUES (1,'Diana','Me'),(2,'Anna','Ano'),(3,'Tom','Bean'),(4,'Emma','Spring');

INSERT INTO `categories` VALUES (1,'Articles about football','Football'),(2,'Articles about soccer','Soccer'),(3,'Articles about pets','Animals'),(4,'Hobby','Hobbies'),(5,'yes','Food and Drinks'),(6,'articles about dance','Dance'),(7,'sports','Sport'),(8,'pets','Home Pets'),(9,'yes','Wild Animals');

INSERT INTO `articles` VALUES (1,'Yes, dogs are great animals.','2018-01-18 17:00:18.293000','Dogs are pretty',NULL,1),(2,'Very scary','2018-01-18 17:00:36.743000','Big bad crocodile',NULL,2),(3,'yes, many many bets','2018-01-18 17:01:27.181000','Bets on football',NULL,3),(4,'Its about dancing','2018-01-18 17:01:42.504000','Very old hobby',NULL,1),(5,'Not chocolate','2018-01-18 17:02:07.480000','What should a dog eat?',NULL,1),(6,'No.','2018-01-18 17:02:25.342000','Can cats dance?',NULL,1);

INSERT INTO `articles_categories` VALUES (1,3),(1,8),(2,3),(2,9),(3,1),(3,4),(3,7),(4,4),(4,6),(5,3),(5,5),(5,8),(6,3),(6,4),(6,6),(6,8);
