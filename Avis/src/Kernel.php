<?php

namespace App;

use Eureka\EurekaClient;
use Symfony\Bundle\FrameworkBundle\Kernel\MicroKernelTrait;
use Symfony\Component\HttpKernel\Kernel as BaseKernel;


class Kernel extends BaseKernel
{
    use MicroKernelTrait;
    public function boot()
    {
        parent::boot();

        $eurekaClient = new EurekaClient([
            'eurekaDefaultUrl' => 'http://localhost:8761/eureka',
            'hostName' => 'localhost',
            'appName' => 'avis',
            'ip' => '127.0.0.1',
            'port' => ['8000', true]
        ]);
        $eurekaClient->register();


    }


}
