package frc.robot.commands

import edu.wpi.first.wpilibj2.command.Command
import frc.robot.subsystems.CANdleSubsystem

/** An example command that uses an example subsystem.  */
class LEDCommand(var brightness:Double) : Command()
{
    init
    {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(CANdleSubsystem)
    }

    override fun initialize()
    {
        // Called when the command is initially scheduled.
        // Here we show an example of calling an action on the ExampleSubsystem

    }

    override fun execute()
    {

        CANdleSubsystem.changeBrightness(brightness)
        // Called every time the scheduler runs while the command is scheduled.
    }

    override fun end(interrupted: Boolean)
    {
        // Called once the command ends or is interrupted.
    }

    override fun isFinished(): Boolean
    {
        // Returns true when the command should end.
        return false
    }
}
