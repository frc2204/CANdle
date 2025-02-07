package frc.robot

import com.ctre.phoenix.led.CANdle
import com.ctre.phoenix.led.FireAnimation
import com.ctre.phoenix.led.LarsonAnimation
import com.ctre.phoenix.led.LarsonAnimation.BounceMode
import edu.wpi.first.wpilibj2.command.CommandScheduler
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.robot.Constants.OperatorConstants
import frc.robot.commands.AnimationCommand
import frc.robot.commands.Autos
import frc.robot.commands.IncrementCommand
import frc.robot.commands.LEDCommand
import frc.robot.subsystems.CANdleSubsystem
import java.util.logging.Logger

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 *
 * In Kotlin, it is recommended that all your Subsystems are Kotlin objects. As such, there
 * can only ever be a single instance. This eliminates the need to create reference variables
 * to the various subsystems in this container to pass into to commands. The commands can just
 * directly reference the (single instance of the) object.
 */
object RobotContainer
{
    private val driverController = CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT)
    val candle = CANdle(0)
    init {
        configureBindings()
        // Reference the Autos object so that it is initialized, placing the chooser on the dashboard
        Autos
        CANdleSubsystem.candleConfig()
        CANdleSubsystem.receiveController(driverController)
        candle.setLEDs(30, 100, 137)
    }

    // Replace with CommandPS4Controller or CommandJoystick if needed


    /**
     * Use this method to define your `trigger->command` mappings. Triggers can be created via the
     * [Trigger] constructor that takes a [BooleanSupplier][java.util.function.BooleanSupplier]
     * with an arbitrary predicate, or via the named factories in [GenericHID][edu.wpi.first.wpilibj2.command.button.CommandGenericHID]
     * subclasses such for [Xbox][CommandXboxController]/[PS4][edu.wpi.first.wpilibj2.command.button.CommandPS4Controller]
     * controllers or [Flight joysticks][edu.wpi.first.wpilibj2.command.button.CommandJoystick].
     */
    private fun configureBindings()
    {
       CANdleSubsystem.defaultCommand = AnimationCommand()
        Trigger(driverController.y().whileTrue(IncrementCommand()))
        Trigger(driverController.a().whileTrue(CANdleSubsystem.CANdleBlue()))
        Trigger(driverController.b().whileTrue(CANdleSubsystem.candleGreen()))
    }
}