package frc.robot.subsystems

import com.ctre.phoenix.led.Animation
import com.ctre.phoenix.led.CANdle
import com.ctre.phoenix.led.CANdleConfiguration
import com.ctre.phoenix.led.ColorFlowAnimation
import com.ctre.phoenix.led.FireAnimation
import com.ctre.phoenix.led.RainbowAnimation
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.button.CommandXboxController

// By making a subsystem a Kotlin object, we ensure there is only ever one instance of it.
// It also reduces the need to have reference variables for the subsystems to be passed around.
object CANdleSubsystem : SubsystemBase()
{
    lateinit var currentAnimation:Animation
    lateinit var nextAnimation:Animation
    var controller: CommandXboxController? = null
    val candle = CANdle(0)
    val AnimationList = mutableListOf<Animation>()
    fun animationConfig(){
        AnimationList.add(ColorFlowAnimation(0,200,130,100,0.7,38,
            ColorFlowAnimation.Direction.Forward))
        AnimationList.add(RainbowAnimation(0.5,0.9,38))
    }
    fun incrementAnimation(){
        val index = AnimationList.indexOf(currentAnimation)
        if(index == 1){
            nextAnimation = AnimationList[1]
            currentAnimation = AnimationList[0]
        } else{
            nextAnimation = AnimationList[0]
            currentAnimation = AnimationList[1]
        }
    }
    fun candleConfig(){
        val config = CANdleConfiguration()
        config.v5Enabled = true
        config.statusLedOffWhenActive = false
        config.brightnessScalar = 1.0
        candle.configAllSettings(config)
        animationConfig()
        currentAnimation = AnimationList[0]
        nextAnimation = AnimationList[1]
    }
    /**
     * Example command factory method.
     *
     * @return a command
     */
    fun candleGreen(): Command = runOnce {
        candle.setLEDs(0,255,0)
    }
    fun receiveController(driveController:CommandXboxController){
        controller = driveController
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
        controller?.let { changeBrightness(it.leftY+0.2) }
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