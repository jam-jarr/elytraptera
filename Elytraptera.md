# Elytraptera

Title: Elytraptera (working title)

Alternative titles:
- Elytron
- Elytra: Hindwing
- Elytra Reimagined

Instead of gliding and rocket-powered flight, elytra now flies like beetle wings.
This enables the elytra as a building and moderate exploration tool, instead of making all other forms of travel obsolete.

- Momentum-based flight
	- Press space while in midair to engage wings (intercept elytra flight event)
	- Press space to apply thrust upwards
  - Press a movement key (WASD) in midair to accelerate in that direction with a fixed max speed
    - Acceleration is proportional to the max speed (use a curve eg. easeOutQuart to make it feel nice and snappy)
  - Pressing space while pressing a direction key changes the thrust direction towards that direction (configurable via option: Horizontal flight sheer)

- Hover mode
	- Press shift while holding space to begin hovering
	- Holding shift lowers your hover height
	- Pressing space again cancels this mode into flight mode

- Stamina system and hunger drain
	- Flying costs "stamina" and saturation level
		- Stamina is restored over time, similar to breathing
	- Hovering costs much less stamina and saturation
  - Flight stamina bar is shown above the hunger bar
  - Hunger drain begins with saturation first, then decreases hunger level. (expected behavior)

- Enchantments
	- Extended flight
		- Increases stamina
	- Takeoff
		- Increases flight thrust at the beginning (first __ milliseconds) of flight
	- Recuperation
		- Increases stamina gain

- Configuration
	- Allow vanilla elytra flight while sprinting (default: no)
	- Base stamina
	- Base horizontal flight speed
	- Hover speed mult
  - Horizontal flight sheer
	- Vertical flight speed
  - Hunger drain while flying
  - Hunger drain while hovering
	- Hover stamina drain
	- Fly stamina drain
