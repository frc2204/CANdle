package frc.robot.commands

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.PrintCommand

object Autos
{
    private val autoModeChooser = SendableChooser<AutoMode>().apply {
        AutoMode.values().forEach { addOption(it.optionName, it) }
    }




    /** Example static factory for an autonomous command.  */
    private fun exampleAuto2() = PrintCommand("An example Auto Mode that just prints a value")

    /**
     * An enumeration of the available autonomous modes. It provides an easy
     * way to manage all our autonomous modes. The [autoModeChooser] iterates
     * over its values, adding each value to the chooser.
     *
     * @param optionName The name for the [autoModeChooser] option.
     * @param command The [Command] to run for this mode.
     */
    @Suppress("unused")
    private enum class AutoMode(val optionName: String, val command: Command)
    {

    }
}