package com.sabr.targeting.policies;

public final class PolicyFactory
{
    public static Policy getPolicy(TargetingPolicyType type)
    {
        switch (type)
        {
            case Random:
                return new DoublePolicy(new RandomPolicy());
            case LeftFirst:
                return new SideFirstPolicy(SideFirstPolicy.Side.Left);
            case RightFirst:
                return new SideFirstPolicy(SideFirstPolicy.Side.Right);
            case BiggestCluster:
                return new DoublePolicy(new BiggestClusterPolicy());
			case Nearest:
				return new LeastRotationPolicy();
        }

        return null;
    }

    public enum TargetingPolicyType
    {
        Random,
        LeftFirst,
        RightFirst,
        BiggestCluster,
		Nearest
    }
}
