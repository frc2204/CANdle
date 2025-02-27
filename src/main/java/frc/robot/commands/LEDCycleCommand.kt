package frc.robot.commands

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj2.command.Command
import frc.robot.subsystems.CANdleSubsystem

/** An example command that uses an example subsystem.  */
class LEDCycleCommand() : Command()
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
        while(true){
            val start = Timer.getFPGATimestamp()
            CANdleSubsystem.candle.setLEDs(255,0,0)
            CANdleSubsystem.candle.setLEDs(0,255,0)
            CANdleSubsystem.candle.setLEDs(0,0,255)
        }
    }

    override fun execute()
    {

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

    override fun runsWhenDisabled(): Boolean {
        return true
    }
}
