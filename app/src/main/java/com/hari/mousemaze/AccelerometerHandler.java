package com.hari.mousemaze;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerHandler implements SensorEventListener
{
    float accelX;
    float accelY;
    float accelZ;

    public AccelerometerHandler(Context paramContext)
    {
        SensorManager localSensorManager = (SensorManager)paramContext.getSystemService("sensor");

        if (localSensorManager.getSensorList(1).size() != 0)
            localSensorManager.registerListener(this, (Sensor)localSensorManager.getSensorList(1).get(0), 1);
    }

    public float getAccelX()
    {
        return this.accelX;
    }

    public float getAccelY()
    {
        return this.accelY;
    }

    public float getAccelZ()
    {
        return this.accelZ;
    }

    public void onAccuracyChanged(Sensor paramSensor, int paramInt)
    {
    }

    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
        this.accelX = paramSensorEvent.values[0];
        this.accelY = paramSensorEvent.values[1];
        this.accelZ = paramSensorEvent.values[2];
    }
}