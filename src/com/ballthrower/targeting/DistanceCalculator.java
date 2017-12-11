package com.ballthrower.targeting;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

// Calculates the distance to the target object based on
// triangle similarity using the height of the target object.
public class DistanceCalculator implements IDistanceCalculateable
{
    /** Physical height, manually measured */
    private static final float _targetHeight = 11.5f;

    /** Pixel height at distance = _knownRealDistance */
    private static final float _knownHeight = 40.0f;

    /** Real distance in centimeters */
    private static final float _knownRealDistance = 115.0f;

    private static final float _cameraElevation = 66f;

    /** Focal length is the distance between the image plane and lens of the camera
      * Used for calculating the distance to an object */
    private static final float _focalLengthHeight = _knownHeight * _knownRealDistance / _targetHeight;

    /**
     * Returns a float representing the distance to the target object.
     * It assumes that the target object is close to directly in front
     * of the image capturing device. For this reason rotation should
     * be performed before attempting to calculate the distance.

     * Input: An instance of a class implementing ITargetContainer
     * which contains sample data received from a data gathering
     * device.

     * Computation:
     *  - Find the median height from the sample list
     *  - Remove samples deviating more than 5% from the median
     *  - Get median from the sample list without outliers
     *  - Calculate the distance using the focal length
     */
    @Override
    public float calculateDistance(TargetBox target)
    {
        return (_focalLengthHeight * _targetHeight / target.getHeight());
    }

}
