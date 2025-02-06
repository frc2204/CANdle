package frc.robot.subsystems

import com.ctre.phoenix.led.CANdle
import com.ctre.phoenix.led.CANdleConfiguration
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.Command

// By making a subsystem a Kotlin object, we ensure there is only ever one instance of it.
// It also reduces the need to have reference variables for the subsystems to be passed around.
object CANdleSubsystem : SubsystemBase()
{
    val candle = CANdle(0)
    fun candleConfig(){
        val config = CANdleConfiguration()
        config.v5Enabled = true
        config.statusLedOffWhenActive = false
        config.brightnessScalar = 1.0
        candle.configAllSettings(config)
    }
    /**
     * Example command factory method.
     *
     * @return a command
     */
    fun candleGreen(): Command = runOnce {
        candle.setLEDs(0,255,0)
    }

    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    fun turnOff(): Boolean {
        // Query some boolean state, such as a digital sensor.
        return true
    }
    fun changeBrightness(brightness: Double){
        candle.configBrightnessScalar(brightness)
    }

    override fun periodic()
    {
        // This method will be called once per scheduler run
    }

    override fun simulationPeriodic()
    {
        // This method will be called once per scheduler run during simulation
    }

    fun CANdleBlue():Command = runOnce {
        // This action is called by the ExampleCommand
        candle.setLEDs(0,0,255)
    }
}