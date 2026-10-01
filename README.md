# Bibliotekshanteraren

Till menyn valde jag att använda en do-while-sats där while sattes till `true` för
att menyn skulle fortsätta visas. Det fungerar eftersom ett av valen i menyn är att
avsluta programmet.

För menyvalen valde jag switch eftersom det är ett smidigt sätt att hantera flera
olika val. Det är även enkelt att lägga till fler val om behov uppstår under arbetets
gång. Valen kopplades sedan till de metoder som skapades för att genomföra
uppgifterna. En fördel med switch är också att man kan använda default för att
smidigt fånga upp felaktiga val.

I uppgiften var det specificerat att Book skulle vara en record, vilket passar bra
då böckernas värden inte behöver ändras efter att objektet skapats. Member behövde
däremot vara en class då man skulle kunna. Genom inkapsling
kan klassen själv kontrollera hur informationen hanteras, istället för att andra
delar av programmet kan ändra fälten direkt.

### Övrig fundering

Det här var mitt första lite större projekt och jag har insett vikten av tydlig
planering. Nu blev det så att jag började lösa det som verkade lättast, vilket
innebar att jag sedan fick ändra efter hand när jag upptäckte att jag missat krav
som fanns. Det gjorde det hela mer rörigt än det hade behövt vara, vilket visade
sig när jag gick igenom ärendehanteraren när allt var klart. Det fanns kod kvar
som inte användes längre, vilket var något förvirrande. 😊