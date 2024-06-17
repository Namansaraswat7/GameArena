# GameArena

Design an Arena:

Each player has 3 properties:

Attack
Strength
Health
In the arena, any two players may engage in combat. In turns, the players attack. The player who is attacking rolls the attacking dice, while the one who is defending rolls the defending dice. The damage done by the attacker is equal to the "attack" value times the result of the attacking dice roll. The damage that the defender defends is equal to their "strength" value multiplied by the result of the defensive dice.
The "health" of the defender will be decreased by any damage the attacker creates that exceeds the damage the defender defends.

When a player's health hits zero, the game is over.

Solution

1. Few edge cases are handled
2. Game Strategy is handled
3. ArenaRuleExecuter is added to handle all arena rules
