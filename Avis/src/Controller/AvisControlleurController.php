<?php

namespace App\Controller;
use App\Entity\Avis;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use App\Repository\AvisRepository;

class AvisControlleurController extends AbstractController
{
    #[Route('/', name: 'app_avis_controlleur')]
    public function index(): Response
    {
        return $this->render('avis_controlleur/index.html.twig', [
            'controller_name' => 'AvisControlleurController',
        ]);
    }

    #[Route('/avis/all', methods: ['GET'],name: "getAvis")]
    public function getAvis(AvisRepository $avisRepository): Response
    {
        $avis = $avisRepository->findAll();

        return $this->json($avis);
    }

    #[Route('/avis/one/{id}', methods: ['GET'],name: "getAvisById")]
    public function getAvisById(int $id, AvisRepository $avisRepository): Response
    {
        $avis = $avisRepository->find($id);

        if (!$avis) {
            return $this->json(['message' => 'Avis not found'], Response::HTTP_NOT_FOUND);
        }

        return $this->json($avis);
    }

    #[Route('/avis/create', methods: ['POST'],name:"createAvis" )]
    public function createAvis(Request $request): Response
    {
        $data = json_decode($request->getContent(), true);

        $avis = new Avis();
        $avis->setName($data['name']);
        $avis->setMessage($data['message']);
        $avis->setIduser($data['iduser']);
        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($avis);
        $entityManager->flush();

        return $this->json($avis);
    }

    #[Route('/avis/update/{id}', methods: ['PUT'],name: "updateAvis")]
    public function updateAvis(Request $request, int $id): Response
    {
        $data = json_decode($request->getContent(), true);

        $avis = $this->getDoctrine()->getRepository(Avis::class)->find($id);

        if (!$avis) {
            return $this->json(['message' => 'Avis not found'], Response::HTTP_NOT_FOUND);
        }

        $avis->setName($data['name']);
        $avis->setMessage($data['message']);

        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->flush();

        return $this->json($avis);
    }

    #[Route('/avis/delete/{id}', methods: ['DELETE'],name:"deleteAvis" )]
    public function deleteAvis(int $id): Response
    {
        $avis = $this->getDoctrine()->getRepository(Avis::class)->find($id);

        if (!$avis) {
            return $this->json(['message' => 'Avis not found'], Response::HTTP_NOT_FOUND);
        }

        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->remove($avis);
        $entityManager->flush();

        return $this->json(['message' => 'Avis deleted successfully']);
    }
}
