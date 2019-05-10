# Assignmen 1 - ZhuoranAndAn

Below listed the design choices made following the program requirments

## Door 

**Updates**

1. `LockedDoor` get allowable action of `OpenDoorAction`
2. `OpenedDoor` class is created when `LockedDoor` is opened by player

## Ninja 

**Updates**

1. `Ninja` now have `ThrowBagAction` which can stun the player in 2 play
2. `StunedPlayer` is inherited from `Player` who can be stuned by `Ninja`
3. `Ninja` also has `MoveAwayBehaviour` which move away from `StunedPlayer` within some distance

## Q

**Updates**
1.  `Q` is created with `AttackAction` removed and `TalkAction` added.
2.  `TalkAction` let `Player` talk and exchange the plans
3.  Once exchange, `Q` is set to disappear





