# Assignmen 1 - ZhuoranAndAn

Below listed the design choices made following the program requirments

## Q

**Design choices**
1.  Create new class `Q` which is a subclass of `Actor`
2.  Create new class `ExchangeAction`, which is an only allowable action player can do when interacts with 'Q'
3.  `ExchangeAction` can be a combination code of `PickUpItemAction` and `DropItemAction` executed in the inventory of player, where one item is replaced by another item. 
4.  `ExchangeAction` checks `RocketPlans` in players' inventory. Item unavailable causes the conversation with `Q` to end. Otherwise, `RocketPlans` is replaced by `RocketBody` and `Q` disappears on the game map

**Advantages**
*  A flexible designe that can extend the role of `Q` in the game later. `Q` may ask for both `RocketPlans` and `Keys` to make the game more challenging
*  Less code needed as `PickUpItemAction` and `DropItemAction` are reusable

**Disadvantages**
*  Add complexity to the overall design of the system
*  Increase the dependencies between classes so the code need to be maintained

## Doctor Maybe

**Design Choices**
1. Create new class `DoctorMaybe` inheriting attributes from `Actor` while not moving
2. When `DoctorMaybe` is defeated, `DropItemAction` is executed and `RocketEngine` is dropped at the place
3. The item is playable by the player

**Advantages**
*  Create new class makes the character more extensible, improving the gaming experience of the user as this boss can be implemented more interesting interactions
*  Bugs can be fairly easy to retrieved as the first initial creation of the boss just reuse existing classes

**Disadvantages**
*  Add complexity to the overall design of the system

## Rocket and build a rocket

**Design Choice**
1. Create new classes `RocketPlans`, `RocketBody`, `RocketEngine`, `Rocket` which are subsclasses of `Item`
2. These classes are basic classes and don't have any special skills for the moment
3. Create new class `RocketPad`, which is of `Ground` class inheritance
4. At `RocketPad`, player have an allowable action of building rocket. The `AssembleRocketAction` will checks both `RocketBody` and `RocketEngine` in player's inventory and replace them with a rocket

**Advantages**
*  The game is more extensible owing to the new classes. Gameplay is more interesting with mission rather than just kill enemies
*  New classes are open for more exiting interactions with the player
*  Simple implementation


** Disadvantages **
* Add complexity to the overall design of the system
* Hard to manage if parts of the rocket have more functions. Need better managing method in the future

